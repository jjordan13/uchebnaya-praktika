package com.voicestudio.service;

import com.voicestudio.model.Actor;
import java.util.List;

public interface IActorSearcher {
    List<Actor> searchByTags(List<String> tagNames);
}