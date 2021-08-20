import axios from "axios";

const BASE_MENU_URL = 'http://localhost:8080/urlshorter';

class ShortUrlService {


    async getShortLink(url) {

        console.log('Url to hashing: ', url);

        try {

            return axios.post(BASE_MENU_URL + '/url', { url: url}, {"headers": {

                    "content-type": "application/json",

                }});

        } catch (e) {

            return {
                id: 'Url not valid'
            };
        }
    };
};

export default new ShortUrlService();
