package com.wolan.voteapp.rest;

import com.sun.corba.se.impl.protocol.RequestCanceledException;
import com.wolan.voteapp.api.Vote;
import com.wolan.voteapp.api.VoteSubject;
import com.wolan.voteapp.exception.NotEditableException;
import com.wolan.voteapp.service.VoteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/vote")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VoteRestController {

    private VoteService voteService;

    @Autowired
    public VoteRestController(VoteService voteService){
        this.voteService = voteService;
    }

    @RequestMapping(method = GET, value = "/subject")
    public List<VoteSubject> findAllVoteSubject() {
        return voteService.findAllVoteSubjects();
    }

    @RequestMapping(method = POST, value = "/vote")
    public Vote vote(@RequestBody Vote vote) throws NotEditableException{
        return voteService.voteFor(vote);
    }

    @ExceptionHandler(NotEditableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody String handleException(Exception e) {
        return e.getMessage();
    }

    @RequestMapping(method = POST, value = "/subject")
    public VoteSubject createVoteSubject(@RequestBody VoteSubject voteSubject) {
        return voteService.createVoteSubject(voteSubject);
    }

}
