package com.milan.snapShot.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.milan.snapShot.entities.Root;
@Component
public class SnapShotService {
	
	public Root getResult(String tag) {
		RestTemplate restTamplate = new RestTemplate();
		Root root = restTamplate
				.getForObject("https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=ef6074dafad6a280f2255e8b9307ffb7&tags=" + tag + "&per_page=24&format=json&nojsoncallback=1", Root.class);
		return root;
	}

}
