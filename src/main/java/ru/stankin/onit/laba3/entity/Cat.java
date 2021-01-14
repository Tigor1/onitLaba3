package ru.stankin.onit.laba3.entity;

import java.util.Date;

public class Cat {
    private Status status;
    private String type;
    private boolean deleted;
    private String _id;
    private long __v;
    private String text;
    private String source;
    private Date updateAt;
    private Date createdAt;
    private boolean used;
    private String user;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public long get__v() {
        return __v;
    }

    public void set__v(long __v) {
        this.__v = __v;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Cat{\n" +
                "   status=" + status + ",\n" +
                "   type='" + type + '\'' + ",\n" +
                "   deleted=" + deleted + ",\n" +
                "   _id='" + _id + '\'' + ",\n" +
                "   __v=" + __v + " \n" +
                "   text='" + text + '\'' + ",\n" +
                "   source='" + source + '\'' + ",\n" +
                "   updateAt=" + updateAt + ",\n" +
                "   createdAt=" + createdAt + ",\n" +
                "   used=" + used + ",\n" +
                "   user='" + user + '\'' + "\n" +
                "}\n";
    }
}

class Status {
    private boolean verified;
    private long sentCount;

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public long getSentCount() {
        return sentCount;
    }

    public void setSentCount(long sentCount) {
        this.sentCount = sentCount;
    }

    @Override
    public String toString() {
        return "Status{\n" +
                "   verified=" + verified + ",\n" +
                "   sentCount=" + sentCount + "\n" +
                "}\n";
    }
}
