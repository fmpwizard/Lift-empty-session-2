package code
package comet

import net.liftweb.http.NamedCometActorTrait
import net.liftweb.http.js.JE.{JsRaw, Call}

class MyCometActor extends NamedCometActorTrait {

  override def lowPriority = {
    case s: String => partialUpdate(JsRaw("alert('" + s+"')" ).cmd)
  }

  //Call calls a js function, JsRaw runs any js you want.
  def render = JsRaw("alert('..')" ).cmd
}
