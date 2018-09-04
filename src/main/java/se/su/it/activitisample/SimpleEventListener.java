package se.su.it.activitisample;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;

import static org.activiti.engine.delegate.event.ActivitiEventType.JOB_EXECUTION_FAILURE;
import static org.activiti.engine.delegate.event.ActivitiEventType.JOB_EXECUTION_SUCCESS;

public class SimpleEventListener implements ActivitiEventListener {
    @Override
    public void onEvent(ActivitiEvent event) {
        System.out.println("ExecutionId: "+event.getExecutionId());
        System.out.println("ProcessDefinitionId: "+event.getProcessDefinitionId());
        System.out.println("ProcessInstanceId: "+event.getProcessInstanceId());
        switch (event.getType()) {

            case JOB_EXECUTION_SUCCESS:
                System.out.println("A job well done!");
                break;

            case JOB_EXECUTION_FAILURE:
                System.out.println("A job has failed...");
                break;

            default:
                System.out.println("Event received: " + event.getType());
        }
    }

    @Override
    public boolean isFailOnException() {
        // The logic in the onEvent method of this listener is not critical, exceptions
        // can be ignored if logging fails...
        return false;
    }
}
