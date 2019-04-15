import React, {Component} from 'react';
import {Grid, Cell} from 'react-mdl';
import Education from './education';
import Experience from './experience';
import Skills from './skills';

class Resume extends Component {
  render() {
    return(
      <div>
        <Grid>
          <Cell col={4}>
            <div style={{textAlign: 'center'}}>
              <img
                src="https://scontent.fphx1-2.fna.fbcdn.net/v/t1.0-9/10931232_829855467055924_9126654785932424179_n.jpg?_nc_cat=100&_nc_ht=scontent.fphx1-2.fna&oh=7b890aa1cc18f2a5b94359d5d4e7cb53&oe=5D48FCBE"
                alt="avatar"
                style={{height: '200px'}}
                 />
            </div>

            <h2 style={{paddingTop: '2em'}}>Sunjil Gahatraj</h2>
            <h4 style={{color: 'grey'}}>Software Developer</h4>
            <h5>Address</h5>
            <p>20425 N 7th St</p>
            <h5>Phone</h5>
            <p>(602) 299-9769</p>
            <h5>Email</h5>
            <p>sunjilgahatraj1@gmail.com</p>

          </Cell>
          <Cell className="resume-right-col" col={8}>
            <h2>Education</h2>


            <Education
              startYear={2014}
              endYear={2019}
              schoolName="Grand Canyon University"
              schoolDescription="BS in Computer Programming"
               />

                <hr style={{borderTop: '3px solid #e22947'}} />

              <h2>Experience</h2>

            <Experience
              startYear={2014}
              endYear={2015}
              jobName="AMC Theatre"
              jobDescription="Customer associate"
              />

              <Experience
                startYear={2015}
                endYear={2019}
                jobName="Grand Canyon University"
                jobDescription="Publishing associate"
                />
              <hr style={{borderTop: '3px solid #e22947'}} />
              <h2>Skills</h2>
              <Skills
                skill="Java"
                progress={80}
                />
                <Skills
                  skill="C#"
                  progress={80}
                  />
                  <Skills
                    skill="PHP"
                    progress={80}
                    />
                    <Skills
                      skill="Sring MVC"
                      progress={75}
                      />
                      <Skills
                        skill=".NET MVC"
                        progress={75}
                        /><Skills
                          skill="Laravel MVC"
                          progress={75}
                          />


          </Cell>
        </Grid>
      </div>
    )
  }
}

export default Resume;
