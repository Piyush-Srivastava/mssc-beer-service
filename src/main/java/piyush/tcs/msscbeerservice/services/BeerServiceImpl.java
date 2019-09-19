package piyush.tcs.msscbeerservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import piyush.tcs.msscbeerservice.domain.Beer;
import piyush.tcs.msscbeerservice.repositories.BeerRepository;
import piyush.tcs.msscbeerservice.web.controller.NotFoundException;
import piyush.tcs.msscbeerservice.web.mappers.BeerMapper;
import piyush.tcs.msscbeerservice.web.model.BeerDto;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getById(UUID beerId) {
        return beerMapper.beerToBeerDto(
                beerRepository.findById(beerId).orElseThrow(NotFoundException::new)
        );
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {

        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
