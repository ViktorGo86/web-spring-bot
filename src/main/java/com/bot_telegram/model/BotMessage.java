package com.bot_telegram.model;

import javax.persistence.*;
// Таблицу "bot_messages" создаем для сервиса Bot Telegram
@Entity
@Table(name = "bot_messages")
public class BotMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "message_id")
    private Integer messageId;

    @Column(name = "name_user", length = 255)
    private String nameUser;

    @Column(name = "name_full", length = 255)
    private String nameFull;

    @Column(name = "message", length = 4000)
    private String messageName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getNameFull() {
        return nameFull;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    @Override
    public String toString() {
        return "BotMessage{" +
                "id=" + id +
                ", userId=" + userId +
                ", messageId=" + messageId +
                ", nameUser='" + nameUser + '\'' +
                ", nameFull='" + nameFull + '\'' +
                ", messageName='" + messageName + '\'' +
                '}';
    }


}
