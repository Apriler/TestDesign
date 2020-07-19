package com.bonc.example.demo.executer;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author luoaojin
 * @CreateTime 2020-07-08
 * @Description
 */
public class NamedThreadFactoryBuilder {

    private String namePrefix = "bdds-";
    private String name = null;
    private Boolean daemon = null;
    private Integer priority = null;
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;
    private ThreadFactory backingThreadFactory = null;

    public NamedThreadFactoryBuilder() {
    }

    public NamedThreadFactoryBuilder(String name){
        if (null==name || "".equals(name.trim())){
            name = "pool";
        }
        this.name = namePrefix + name;
    }

    /**
     * Sets the priority for new threads created with this ThreadFactory.
     *
     * @param priority the priority for new Threads created with this
     *     ThreadFactory
     * @return this for the builder pattern
     */
    public NamedThreadFactoryBuilder setPriority(int priority) {
        // Thread#setPriority() already checks for validity. These error messages
        // are nicer though and will fail-fast.
        checkArgument(priority >= Thread.MIN_PRIORITY,
                "Thread priority (%s) must be >= %s", priority, Thread.MIN_PRIORITY);
        checkArgument(priority <= Thread.MAX_PRIORITY,
                "Thread priority (%s) must be <= %s", priority, Thread.MAX_PRIORITY);
        this.priority = priority;
        return this;
    }

    /**
     * Sets the {@link Thread.UncaughtExceptionHandler} for new threads created with this
     * ThreadFactory.
     *
     * @param uncaughtExceptionHandler the uncaught exception handler for new
     *     Threads created with this ThreadFactory
     * @return this for the builder pattern
     */
    public NamedThreadFactoryBuilder setUncaughtExceptionHandler(
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.uncaughtExceptionHandler = checkNotNull(uncaughtExceptionHandler);
        return this;
    }

    /**
     * Sets the backing {@link ThreadFactory} for new threads created with this
     * ThreadFactory. Threads will be created by invoking #newThread(Runnable) on
     * this backing {@link ThreadFactory}.
     *
     * @param backingThreadFactory the backing {@link ThreadFactory} which will
     *     be delegated to during thread creation.
     * @return this for the builder pattern
     *
     * @see MoreExecutors
     */
    public NamedThreadFactoryBuilder setThreadFactory(
            ThreadFactory backingThreadFactory) {
        this.backingThreadFactory = checkNotNull(backingThreadFactory);
        return this;
    }

    /**
     * Returns a new thread factory using the options supplied during the building
     * process. After building, it is still possible to change the options used to
     * build the ThreadFactory and/or build again. State is not shared amongst
     * built instances.
     *
     * @return the fully constructed {@link ThreadFactory}
     */
    public ThreadFactory build() {
        return build(this);
    }

    public ThreadFactory build(NamedThreadFactoryBuilder builder){
        final ThreadFactory backingThreadFactory =
                (builder.backingThreadFactory != null)
                        ? builder.backingThreadFactory
                        : Executors.defaultThreadFactory();
        final AtomicLong count = (name != null) ? new AtomicLong(0) : null;
        return new ThreadFactory() {
            @Override public Thread newThread(Runnable runnable) {
                Thread thread = backingThreadFactory.newThread(runnable);
                if (name != null) {
                    thread.setName(String.format(name, count.getAndIncrement()));
                }
                if (priority != null) {
                    thread.setPriority(priority);
                }
                if (uncaughtExceptionHandler != null) {
                    thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
                }
                return thread;
            }
        };
    }

}
