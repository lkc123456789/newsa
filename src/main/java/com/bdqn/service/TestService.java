package com.bdqn.service;

import com.bdqn.entity.IndexAll;
import com.bdqn.entity.News;
import com.bdqn.entity.Page;

public interface TestService {
    public IndexAll selectAll(Page page);
    public News selectById(String id);
}
