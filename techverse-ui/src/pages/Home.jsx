import React from "react";
import styled from "styled-components";

const HomeContainer = styled.div`
  margin: 0 auto;
  padding: 20px;
`;

const Title = styled.h3`
  font-size: 28px;
  font-weight: 600;
  color: #333;
  margin-bottom: 20px;
`;

const Description = styled.p`
  font-size: 16px;
  line-height: 1.6;
  color: #555;
  margin-bottom: 20px;
`;

const ListContainer = styled.div`
  margin-bottom: 20px;
`;

const ListItem = styled.li`
  font-size: 16px;
  line-height: 1.6;
  color: #555;
  margin-bottom: 10px;
`;

const Home = () => {
  return (
    <HomeContainer>
      <Title>Welcome to TechVerse - Where Queries Meet Conclusion!</Title>
      <Description>
        TechVerse is a platform that connects individuals and businesses with
        tech experts from various fields. Whether you're a developer, designer,
        data scientist, or IT professional, TechVerse is the go-to destination
        for finding the right tech expert for your needs.
      </Description>
      <ListContainer>
        <p>What TechVerse Offers:</p>
        <ul>
          <ListItem>
            Find Tech Experts: With our powerful search functionality, you can
            easily search and filter through a diverse pool of tech experts
            based on their expertise, experience, and location. Whether you need
            help with a specific technology stack or a particular project,
            TechVerse has got you covered.
          </ListItem>
          <ListItem>
            Learn from the Best: TechVerse isn't just about finding experts;
            it's also a hub for knowledge sharing. Browse through the profiles
            of tech gurus, read about their accomplishments, and get inspired by
            their success stories. Learn from the best and stay updated with the
            latest trends in the tech industry.
          </ListItem>
          <ListItem>
            Connect and Collaborate: Connect with tech experts and like-minded
            individuals through our interactive platform. Collaborate on
            projects, participate in discussions, and exchange ideas to enhance
            your skills and grow your network.
          </ListItem>
          <ListItem>
            Showcase Your Talent: If you're a tech expert looking to showcase
            your skills and build your reputation, TechVerse provides a
            dedicated profile space where you can highlight your expertise,
            projects, and achievements. Get noticed by potential clients and
            employers looking for top-notch talent.
          </ListItem>
          <ListItem>
            Verified Profiles: At TechVerse, we prioritize credibility and
            authenticity. All tech expert profiles are verified, ensuring you
            get in touch with genuine professionals who can add value to your
            projects.
          </ListItem>
        </ul>
      </ListContainer>
      <Description>
        TechVerse is your one-stop solution for all things tech-related. Whether
        you're an individual seeking expert advice or a tech guru eager to share
        your knowledge, TechVerse welcomes you to join our growing community of
        tech enthusiasts. Start your tech journey with TechVerse today!
      </Description>
    </HomeContainer>
  );
};

export default Home;
