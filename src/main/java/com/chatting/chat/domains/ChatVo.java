package com.chatting.chat.domains;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatVo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long projectId;
 // @ManyToOne
 // @JoinColumn(name ="account_id")
 // private Account sender;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String sender;

    @Column(columnDefinition = "TEXT", nullable = false)
	private String message;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime sendDateTime;

    public String getSendMessage(){
        return id + " | " + projectId + " | " + sender + " | " + message + " | " + sendDateTime;
    }

}
