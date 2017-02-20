package de.adorsys.multibanking.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by alexg on 07.02.17.
 */
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    private String id;
    @Indexed
    private String accountId;
    @Indexed(unique = true)
    private String externalId;
    private BankAccount otherAccount;
    private Date valutaDate;
    private Date bookingDate;
    private BigDecimal amount;
    private boolean isReversal;
    private BigDecimal balance;
    private String customerRef;
    private String instRef;
    private BigDecimal origValue;
    private BigDecimal chargeValue;
    private String additional;
    private String text;
    private String primanota;
    private String usage;
    private String addkey;
    private boolean isSepa;

}
