package com.aston.hateoasdemo.bootstrap;

import com.aston.hateoasdemo.domain.Continent;
import com.aston.hateoasdemo.domain.Country;
import com.aston.hateoasdemo.domain.Hemisphere;
import com.aston.hateoasdemo.domain.Province;
import com.aston.hateoasdemo.domain.services.ContinentService;
import com.aston.hateoasdemo.domain.services.CountryService;
import com.aston.hateoasdemo.domain.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private final ContinentService continentService;

    @Autowired
    private final CountryService countryService;

    @Autowired
    private final ProvinceService provinceService;

    public SeedData(ContinentService continentService, CountryService countryService, ProvinceService provinceService) {
        this.continentService = continentService;
        this.countryService = countryService;
        this.provinceService = provinceService;
    }

    @Transactional
    @Override
    public void run(String... strings) throws Exception {

        if (continentService.listAllContinents().spliterator().getExactSizeIfKnown() == 0) {
            //only load data if no data loaded
            initData();
        }
    }

    private void initData() {

        Hemisphere north = new Hemisphere("Northern");
        Hemisphere south = new Hemisphere("Southern");
        Hemisphere west = new Hemisphere("Western");
        Hemisphere east = new Hemisphere("Eastern");

        Continent nAmerica = new Continent("North America",Stream.of(north,west).collect(Collectors.toList()));
        Continent sAmerica = new Continent("South America",Stream.of(south,west).collect(Collectors.toList()));
        Continent europe = new Continent("Europe",Stream.of(north,east).collect(Collectors.toList()));
        Continent africa = new Continent("Africa",Stream.of(south,east).collect(Collectors.toList()));
        Continent asia = new Continent("Asia",Stream.of(north,south,east).collect(Collectors.toList()));
        Continent oceania = new Continent("Oceania",Stream.of(south,east).collect(Collectors.toList()));

        Country unitedStates = new Country("United States of America", "Washington D.C.",322179605,nAmerica);
        Country unitedKingdom = new Country("United Kingdom","London",65788574,europe);
        Country argentina = new Country("Argentina","Buenos Aires",43847430,sAmerica);
        Country egypt = new Country("Egypt","Cairo",95688681,africa);
        Country japan = new Country("Japan","Tokyo",127748513,asia);
        Country australia = new Country("Australia","Sydney",24125848,oceania);

        Province minnesota = new Province("Minnesota","Saint Paul",5576606,unitedStates);
        Province newYork = new Province("New York","New York City",19849399,unitedStates);
        Province california = new Province("California","Sacramento",39536653,unitedStates);
        Province massachusetts = new Province("Massachusetts","Boston",6859819,unitedStates);

        continentService.saveContinentList(Stream.of(nAmerica,sAmerica,europe,africa,asia,oceania).collect(Collectors.toList()));
        countryService.saveCountryList(Stream.of(unitedStates,unitedKingdom,argentina,egypt,japan,australia).collect(Collectors.toList()));
        provinceService.saveProvinceList(Stream.of(minnesota,newYork,california,massachusetts).collect(Collectors.toList()));

    }
}
