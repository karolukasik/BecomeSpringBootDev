package io.datajek.springmvc;

import io.datajek.springmvc.validation.HeadToHead;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlayerStats {
    private String playerOne;
    private String playerTwo;
    @HeadToHead
    private String head2head;
}
