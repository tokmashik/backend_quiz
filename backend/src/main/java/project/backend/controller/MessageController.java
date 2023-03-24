package project.backend.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.backend.domain.Message;
import project.backend.domain.Views;
import project.backend.repo.MessageRepo;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {
        private final MessageRepo messageRepo;
        @Autowired
        private MessageController(MessageRepo messageRepo) {
            this.messageRepo = messageRepo;
        }

        @GetMapping
        @JsonView({Views.IdName.class})
    public List<Message> list() {
        return messageRepo.findAll();
    }

    @GetMapping("{id}")
    public Message getOne(@PathVariable("id") Message message) {
        return message;
    }

    @PostMapping
    public Message create(@RequestBody Message message) {
        message.setCreationDate(LocalDateTime.now());
        return messageRepo.save(message);
    }

        @PutMapping("{id}")
        public Message update(
                @PathVariable("id") Message messageFromDb,
                @RequestBody Message message
        ) {
            BeanUtils.copyProperties(message, messageFromDb, "id");
            return messageRepo.save(messageFromDb);
        }

        @DeleteMapping("{id}")
        public void delete(@PathVariable("id") Message message) {
            messageRepo.delete(message);
        }
}
