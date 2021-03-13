package org.techtown.customadapterapp.VO;

public class ChattingRoom {
    private String roomName;
    private String lastChatDate;
    private String lastChatMsg;

    public ChattingRoom(String roomName, String lastChatDate, String lastChatMsg) {
        this.roomName = roomName;
        this.lastChatDate = lastChatDate;
        this.lastChatMsg = lastChatMsg;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getLastChatDate() {
        return lastChatDate;
    }

    public void setLastChatDate(String lastChatDate) {
        this.lastChatDate = lastChatDate;
    }

    public String getLastChatMsg() {
        return lastChatMsg;
    }

    public void setLastChatMsg(String lastChatMsg) {
        this.lastChatMsg = lastChatMsg;
    }
}
