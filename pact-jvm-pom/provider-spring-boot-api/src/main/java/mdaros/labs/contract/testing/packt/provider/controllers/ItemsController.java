package mdaros.labs.contract.testing.packt.provider.controllers;

import mdaros.labs.contract.testing.packt.provider.model.Item;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping ( value = "/api/v1" )
public class ItemsController {

	@RequestMapping ( value = "/items", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
	public List<Item> getItems () {

		Item item = Item.builder ()
				.name ( "tom" )
				.condition ( true )
				.build ();

		return Collections.singletonList ( item );
	}

	@RequestMapping ( value = "/items", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity createItem ( Item item ) {

		// TOOD Update the status
		HttpHeaders headers = new HttpHeaders ();
		headers.add ( HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE );

		return new ResponseEntity ( null, headers, HttpStatus.valueOf ( 201 ) );
	}
}