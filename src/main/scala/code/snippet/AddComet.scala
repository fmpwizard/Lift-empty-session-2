package code.snippet

import net.liftweb.http.NamedCometActorSnippet

/**
 * Created with IntelliJ IDEA.
 * User: diego.medina
 * Date: 6/25/12
 * Time: 1:11 PM
 * To change this template use File | Settings | File Templates.
 */

object AddComet extends NamedCometActorSnippet{

  def name = "global" // this can be S.param("query").openOr("") and then for urls like
  // http://127.0.0.1/index?query=1  ,the name will be 1
  def cometClass = "MyCometActor"
}
