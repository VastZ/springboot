package com.boot.service;

import com.boot.db.entity.OldLost;

public interface OldLostService {

    void sendRequest(OldLost oldLost, int i, int all);

}
