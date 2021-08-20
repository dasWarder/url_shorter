import './App.css';
import { useState } from "react";

const ConvertPanel = (props) => {

    const [url, setUrl] = useState('');

    const changeUrlHandler = (e) => {
        setUrl( () => {
            return e.target.value;
        })
    };

    const sendResult = (e) => {

        e.preventDefault();

        props.changeUrl(url);
    }

    return (
        <form style={ { margin: '15px auto', fontSize: '2em', fontFamily: "Comic Sans MS", textAlign: 'center'} } onSubmit={ sendResult }>
            <label>Your URL:</label>
            <input className='Main-find'
                   type='text'
                   value={ url }
                   onChange={ changeUrlHandler }
                   placeholder='Enter your URL here'/>
            <input type='submit' className='Main-container-convert-button' value='Get short' />
        </form>
    )
}

export default ConvertPanel;