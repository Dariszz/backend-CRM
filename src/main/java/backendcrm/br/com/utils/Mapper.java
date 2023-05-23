package backendcrm.br.com.utils;



import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class Mapper {

    public static final ModelMapper INSTANCE = new ModelMapper();

}
