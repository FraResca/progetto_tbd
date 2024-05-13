import React from 'react'
import AliceCarousel from 'react-alice-carousel'
import 'react-alice-carousel/lib/alice-carousel.css'



const HomeCarousel = () => {

    return (
        <div className="App">
            <AliceCarousel disableButtonsControl autoPlay infinite autoPlayInterval="3000">
                <img src={"https://img.freepik.com/premium-vector/health-hospital-doctor-covid19-instagram-carousel-template_500947-283.jpg?w=2000"} className="sliderimg" alt="" />
                <img src={"https://img.freepik.com/premium-vector/health-hospital-doctor-covid19-instagram-carousel-template_500947-281.jpg?w=2000"} className="sliderimg" alt="" />
                <img src={"https://img.freepik.com/premium-vector/health-hospital-doctor-covid19-instagram-carousel-template_500947-283.jpg?w=2000"} className="sliderimg" alt="" />
                <img src={"https://img.freepik.com/premium-vector/health-hospital-doctor-covid19-instagram-carousel-template_500947-282.jpg?w=2000"} className="sliderimg" alt="" />

            </AliceCarousel>
        </div>
    );
}

export default HomeCarousel