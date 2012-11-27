package com.acme.training.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("XmlRepo")
@Qualifier("xml")
public class XmlConfigurableRestaurantRepository extends AbstractRestaurantRepository {

}
