package com.github.shymega.graal.minimalexample;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // seems to make Jackson work in main project, here to demonstrate issue
@Data // also here to demonstrate issue
public class Transaction {
    private String txUuid;
    private int amount;
    private String source;
}
