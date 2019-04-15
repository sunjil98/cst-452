/*I have used following youtube channel as resource for this project. https://www.youtube.com/channel/UCnj8dl6NWgASf4kKZLuuwfw */
import React, {Component} from 'react';
import {Grid, Cell} from 'react-mdl';

class LandingPage extends Component
{
  render()
  {
    return(
      <div style={{width: '100%', margin: 'auto'}} >
      <Grid className= "landing-grid">
      <Cell col={12}>
        <img
        src="https://www.shareicon.net/download/2015/09/18/103157_man_512x512.png"
          alt="profilePic"
           className="profilePic-img"
        />
        <div className="banner-text">
        <h1>Full Stack Web Developer</h1>
        <hr/>
        <p> Spring MVC  | J2EE  | MVC.Net  | Laravel  | HTML/CSS  | MySQL</p>
            <div className= "social-link">
            {/*linkedin*/}
              <a href="https://www.linkedin.com/in/sunjil-gahatraj-a44256158/" rel="noopener noreferer" target="-blank">
                <i className="fa fa-linkedin-square" aria-hidden="true"/>
              </a>

              {/*Github*/}
                <a href="https://github.com/sunjil98" rel="noopener noreferer" target="-blank">
                  <i className="fa fa-github-square" aria-hidden="true"/>
                </a>

                {/*bitbucket*/}
                  <a href="https://bitbucket.org/dashboard/overview" rel="noopener noreferer" target="-blank">
                    <i className="fa fa-bitbucket-square" aria-hidden="true"/>
                  </a>
            </div>
        </div>
      </Cell>
      </Grid>
       </div>
    )
  }
}

export default LandingPage;
