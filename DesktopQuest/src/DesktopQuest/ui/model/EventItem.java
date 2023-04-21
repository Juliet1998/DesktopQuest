package DesktopQuest.ui.model;

import java.util.HashMap;

public class EventItem {

    private String EventLog;
    private String EventName;

    private HashMap<String,Eventresult> EventActions;

    public EventItem() {
        EventLog = "This is a Event.";
        EventName = "This is the Event name"; //for mark of special event
        EventActions = new HashMap<String, Eventresult>();
    }

    public class Eventresult{
        private String ResultLog;
        private String[] ResultAction;

        public Eventresult(String resultLog, String[] resultAction) {
            ResultLog = resultLog;
            ResultAction = resultAction;
        }

        public String getResultLog() {
            return ResultLog;
        }

        public String[] getResultAction() {
            return ResultAction;
        }
    }

    public void addEventAction(String Action, Eventresult Result){
        EventActions.put(Action,Result);
    }

    public Eventresult getEventResult(String Action){
        return EventActions.get(Action);
    }

    public String getEventLog() {
        return EventLog;
    }

    public void setEventLog(String eventLog) {
        EventLog = eventLog;
    }

    public HashMap<String,Eventresult> getEventActions() {
        return EventActions;
    }

    public void setEventActions(HashMap<String,Eventresult> eventActions) {
        EventActions = eventActions;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getEventName() {
        return EventName;
    }
}
