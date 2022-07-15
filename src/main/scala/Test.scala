import org.apache.spark.sql.catalyst.expressions.{Alias, ExprId, NamedExpression}
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan

import scala.collection.mutable

/**
 * @Author luoaojin
 * @Date 2022/4/6 16:23
 * @Description
 * @Version 1.0
 */
class Test {
  def main(args: Array[String]): Unit = {
//    collectAllAliases()


  }

  private def collectAllAliases(plan: LogicalPlan): mutable.HashMap[Alias, ExprId] = {
    val aliases = new mutable.HashMap[Alias, ExprId]()
    plan.transformAllExpressions {
      case a: Alias =>
        a.child transformUp {
          case ne: NamedExpression =>
            aliases.getOrElseUpdate(a, ne.exprId)
            ne
        }
        a
    }
    aliases
  }

}
