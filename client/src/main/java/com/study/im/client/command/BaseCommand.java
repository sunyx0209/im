package com.study.im.client.command;

import java.util.Scanner;

public interface BaseCommand {
    String getKey();
    String getTip();
    void exec(Scanner scanner);
}
