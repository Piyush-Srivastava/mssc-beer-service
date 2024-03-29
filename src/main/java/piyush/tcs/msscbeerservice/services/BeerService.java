package piyush.tcs.msscbeerservice.services;

import piyush.tcs.msscbeerservice.web.model.BeerDto;

import java.util.UUID;

public interface BeerService
{

    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
