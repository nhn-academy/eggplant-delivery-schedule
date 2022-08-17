# 🕰 Eggplant-Delivery-schedule
> Eggplant Delivery-Schedule 서비스는 Eggplant-Delivery dummy DB를 시간별로 (Spring Batch를 이용) 수정하는 서비스를 수행합니다.

# Getting Started
- 해당 프로젝트를 다운로드하거나 `git clone` 을 통해 실행 환경을 구성한 뒤, 다음과 같은 명령어를 실행합니다.

```
./mvnw spring-boot:run
```

# Project Architecture

![배송](https://user-images.githubusercontent.com/53285909/184058391-1a8d0582-a190-456c-b1a7-40b7dbf6159a.svg)

![image](https://user-images.githubusercontent.com/53285909/184069587-cee635ea-0f6c-454a-a004-6cbaa69abd1f.png)

# Features

- 배송 상태 변경 (Co-authored-by: [@김훈민](http://github.com/bunsung92), [@조재철](https://github.com/JoisFe))
  - 배송 준비 중 --> 배송 중 (위치 1)
  - 배송 중 (위치 1) --> 배송 중 (위치 2)
  - 배송 중(위치 2) --> 배송 완료
  
* 특정 시간 기준으로 랜덤으로 해당 상태 10개를 뽑아서 상태를 변경함

# Tech Issue

- 만약 운용상 큐가 밀리고 있음. 어떻게 처리 할것인가?
- 만약 재진입 무한루프 `Queue` 가 발생시 어떻게 처리 할 것인가?
- `Batch` 의 `JOB` 주기의 시간을 랜덤으로 줄 수 있음. 도입 고려 해 볼것.
- `JpaPagingItemReader` 를 도입 해 볼 수 있나?
  - Query DSL 복잡한 쿼리에는 사용하기 어려울 것 같음.


## Tech Stack
### Build Tools

![ApacheMaven](https://img.shields.io/badge/Maven-C71A36?style=flat&logo=ApacheMaven&logoColor=white)

### Datebases

![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=MySQL&logoColor=white)

### DevOps

![GitHubActions](https://img.shields.io/badge/GitHub%20Actions-2088FF?style=flat&logo=GitHubActions&logoColor=white)
![SonarQube](https://img.shields.io/badge/SonarQube-4E98CD?style=flat&logo=SonarQube&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat&logo=Docker&logoColor=white)
![RabbitMQ](http://img.shields.io/badge/RabbitMQ-FF81F9?style=flat&logo=RabbitMQ&logoColor=#FF6600)

### Frameworks

![SpringBoot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=flat&logo=SpringBoot&logoColor=white)
![Spring Batch](https://img.shields.io/badge/Spring%20Batch-6DB33F?style=flat&logo=Spring&logoColor=white)

### Languages

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white&style=flat)

### Testing Tools

![Junit5](https://img.shields.io/badge/Junit5-25A162?style=flat&logo=Junit5&logoColor=white)

### 형상 관리 전략

![Git](https://img.shields.io/badge/Git-F05032?style=flat&logo=Git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-181717?style=flat&logo=GitHub&logoColor=white)
![Sourcetree](https://img.shields.io/badge/Sourcetree-0052CC?style=flat&logo=Sourcetree&logoColor=white)

- Git Flow 를 사용하여 관리
  모든 브랜치는 Pull Request에 코드 리뷰 진행 후 merge 합니다.
- ![gitflow-workflow](https://user-images.githubusercontent.com/54662174/183854876-aa8c7e55-ce19-4cbf-ba7c-8921ab7a8ab8.png)
- `main`: 배포시 사용
- `develop`: 개발 단계가 끝난 부분에 대해서 merge 내용 포함
- `feature`: 기능 개발 단계
- `hotfix`: merge 후 발생한 버그 및 수정사항 반영 시 사용

## ERD
![image](https://user-images.githubusercontent.com/53285909/184069243-7778ccaf-c36d-4562-ac86-2f3debc66599.png)
## Contributors

<a href="https://github.com/nhn-academy/eggplant-delivery/graphs/contributors">
<img src="https://contrib.rocks/image?repo=nhn-academy/eggplant-delivery" />
</a>


## License

`Eggplant-Delivery-Schedule` is released under version 2.0 of the [Apache License](https://www.apache.org/licenses/LICENSE-2.0).
