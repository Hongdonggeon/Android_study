package org.techtown.application0313.VO;

public class ChattingRoom implements Comparable<ChattingRoom> {
    private String name;
    private String lastMessage;
    private String lastTime;

    public ChattingRoom(){
        this(null,null,null);
    }


    public ChattingRoom(String name) {
        this(name,null,null);
    }

    public ChattingRoom(String name, String lastMessage, String lastTime) {
        this.name = name;
        this.lastMessage = lastMessage;
        this.lastTime = lastTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    @Override
    public int compareTo(ChattingRoom other) {
        return lastTime.compareTo(other.getLastTime());
    }
}
