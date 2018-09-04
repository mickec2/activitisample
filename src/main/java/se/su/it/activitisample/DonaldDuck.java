package se.su.it.activitisample;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class DonaldDuck implements JavaDelegate {
    public void execute(DelegateExecution execution) {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        String someVariable = (String) execution.getVariable("kalleanka");
        if(null==someVariable) {
            someVariable = "";
        }
        execution.setVariable("kalleanka", someVariable.toUpperCase());
    }
}
