package code

import net.liftweb.common.{Full, Empty, Logger}
import akka.actor.{ActorSystem, Actor}
import akka.actor
import akka.util.duration._
import akka.util.Duration
import net.liftweb.http.{NamedCometListener, S}

class Main extends Actor with Logger {

  case object Tick

  context.system.scheduler.schedule(Duration.Zero, 5 seconds, self, Tick)

  protected def receive = {
    case Tick => {
      debug("..")

      /**
       * Find all comet actors that are have the name "global"
       */
      NamedCometListener.getDispatchersFor(Full("global")).foreach{
        actor => actor.map(_ ! "...")
      }
    }
    case m: Any => warn("Unknown message")
  }
}

object Main {

  val system = ActorSystem("Main")
  val instance = system.actorOf(actor.Props[Main], "main")
}
