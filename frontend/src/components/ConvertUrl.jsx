import './App.css';
import { useState } from "react";
import ShortUrlView from "./ShortUrlView";
import ConvertPanel from "./ConvertPanel";
import ShortUrlService from "../service/ShortUrlService";

const ConvertUrl = () => {

    const [shortUrl, setShortUrl] = useState('');
    const [urlObj, setUrlObj] = useState({
        id:'',
        url: '',
        created:''
    });

    const BASE_URL = 'http://localhost:8080/urlshorter';


    const changeHandler = (url) => {
        const responseData = ShortUrlService.getShortLink(url);

        responseData.then(res => {

            let data = res.data;

            if(!data.hasOwnProperty('code')) {
                setUrlObj({urlObj: data});
                setShortUrl(() => {
                    return `${BASE_URL}/${data.id}`;
                })
            } else {
                setShortUrl( () => {
                    return 'Not valid URL!';
                })
            }
        } );
    };

    return (
        <div className='Main-container-search'>
            <ConvertPanel changeUrl={ changeHandler }/>
            <ShortUrlView url={ shortUrl } />
        </div>
    )

};

export default ConvertUrl;