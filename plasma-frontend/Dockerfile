FROM node:latest
RUN mkdir -p /src
WORKDIR /src
COPY package.json /src/
RUN npm install --force
RUN npm cache verify
COPY . /src
EXPOSE 4200/tcp
CMD ["npm","start","--","--host","0.0.0.0","--poll","2000","--disableHostCheck","true"]
