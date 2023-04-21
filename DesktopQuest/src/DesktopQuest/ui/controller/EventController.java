package DesktopQuest.ui.controller;

import DesktopQuest.ui.model.EventItem;
import DesktopQuest.ui.model.Events;
import DesktopQuest.ui.view.EventIntFrame;
import DesktopQuest.ui.view.MapIntFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EventController {
    //get event from event list and interact with EventintFrame
    private EventIntFrame eventIntFrame;
    private Events events;
    private List<EventItem> eventList;
    private StatusController StatusCon;
    private MapIntFrame mapIntFrame;
    private MainFrameController mainFrameController;

    public EventController() {
        events = new Events();
        eventList = events.getEventList();
    }

    public EventIntFrame fillEvent(){
        //return event frame with a random event
        Random rand = new Random();
        EventItem event = eventList.get(rand.nextInt(eventList.size()));
        eventIntFrame = new EventIntFrame(event);
        if (event.getEventName().equals("java")){eventList.remove(event);}
        if (StatusCon != null) {eventIntFrame.setStatusCon(StatusCon);}
        if (mapIntFrame != null) {eventIntFrame.setCurrentEvent(mapIntFrame.getCurrentEvent());}
        if (mainFrameController != null) {eventIntFrame.setMainFrameController(mainFrameController);}
        return eventIntFrame;
    }

    public void setEventIntFrame(EventIntFrame eventIntFrame) {
        this.eventIntFrame = eventIntFrame;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    public void setStatusCon(StatusController statusCon) {
        StatusCon = statusCon;
    }

    public void setMapIntFrame(MapIntFrame mapIntFrame) {
        this.mapIntFrame = mapIntFrame;
    }

    public void setMainFrameController(MainFrameController mainFrameController) {
        this.mainFrameController = mainFrameController;
    }

    public EventIntFrame getEventIntFrame() {
        //return event frame
        if (eventIntFrame == null){
            return null;
        }else return eventIntFrame;
    }

    public EventIntFrame getStartEvent() {
        eventIntFrame = new EventIntFrame(events.getStartEvent());
        if (StatusCon != null) {eventIntFrame.setStatusCon(StatusCon);}
        if (mapIntFrame != null) {eventIntFrame.setCurrentEvent(mapIntFrame.getCurrentEvent());}
        if (mainFrameController != null) {eventIntFrame.setMainFrameController(mainFrameController);}

        return eventIntFrame;
    }

    public EventIntFrame getFinalEvent() {
        eventIntFrame = new EventIntFrame(events.getFinalEvent());
        if (StatusCon != null) {eventIntFrame.setStatusCon(StatusCon);}
        if (mapIntFrame != null) {eventIntFrame.setCurrentEvent(mapIntFrame.getCurrentEvent());}
        if (mainFrameController != null) {eventIntFrame.setMainFrameController(mainFrameController);}
        eventIntFrame.setGoal();
        return eventIntFrame;
    }

    public EventIntFrame getShopEvent() {
        eventIntFrame = new EventIntFrame(events.getShopEvent());
        try {
            eventIntFrame.setFrameIcon(new ImageIcon(getClass().getResource("/shop16.png")));
        }catch (Exception e){}
        if (StatusCon != null) {eventIntFrame.setStatusCon(StatusCon);}
        if (mapIntFrame != null) {eventIntFrame.setCurrentEvent(mapIntFrame.getCurrentEvent());}
        if (mainFrameController != null) {eventIntFrame.setMainFrameController(mainFrameController);}
        return eventIntFrame;
    }
}
