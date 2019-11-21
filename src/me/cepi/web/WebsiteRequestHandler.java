package me.cepi.web;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

@SuppressWarnings("restriction")
public interface WebsiteRequestHandler {

    String handle(HttpExchange exchange, String request) throws IOException;
}