package piyush.tcs.msscbeerservice.web.mappers;

import org.mapstruct.Mapper;
import piyush.tcs.msscbeerservice.domain.Beer;
import piyush.tcs.msscbeerservice.web.model.BeerDto;

@Mapper(uses= DateMapper.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto dto);
}
