import './App.css';

const ShortUrlView = (props) => {

    let shortUrl = props.url;

    let block = shortUrl === ''?

        <div>
        </div>

        :

        <div>
            <p style={ { fontSize: '2em', margin: '0' } }>Your short link: </p>
            <div className= 'Main-container-display'>
                { shortUrl }
            </div>
        </div>


    return (
        <div>
            { block }
        </div>
    )

};

export default ShortUrlView;