package distributed.ai.communication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Thomas Somers
 * @version 1.0 1/10/2020 15:35
 */

@Data

public class Song {
    private String title;
    private String band;
    public Song(String name, String author){
        title=name;
        band=author;
    }


    //Uit te bereiden
}
