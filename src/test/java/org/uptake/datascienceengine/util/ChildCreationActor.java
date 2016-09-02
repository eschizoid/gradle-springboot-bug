package org.uptake.datascienceengine.util;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import lombok.extern.slf4j.Slf4j;

/**
 * Utility actor that does nothing but take a Props and create
 * whatever actor the Props points to
 */
@Slf4j
public class ChildCreationActor extends UntypedActor {

    @Override
    public void onReceive(Object o) throws Exception {
        if (o instanceof ChildArgs) {
            ChildArgs childArgs = (ChildArgs)o;
            ActorRef child = getContext().actorOf(childArgs.props, childArgs.actorName);
            log.debug("Created child actor: " + child.path().toString());
        }
        else {
            unhandled(o);
        }
    }

    /**
     * The only usable msg to ChildCreationActor. Defines the child actor to create
     */
    public static class ChildArgs {
        public final String actorName;
        public final Props props;

        public ChildArgs(Props props, String actorName) {
            this.actorName = actorName;
            this.props = props;
        }
    }
}