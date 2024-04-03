FROM node:lts-alpine

#curl 설치 (client-url): 필수는 아님(postman 같은 것이다.)
RUN apk add --no-cache curl

#app 폴더에 현재 위치에 있는 모든 파일을 복사시킨다.
WORKDIR /app
COPY . ./
RUN npm install
CMD ["npm", "run", "dev", "--", "--host", "0.0.0.0"] 