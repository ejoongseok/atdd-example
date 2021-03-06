## ATTD 기반 Web Application 개발 예제

### 요구사항

사용자(Employee)는 lastName을 인자로 인사말(greeting)을 요구한다. 시스템은 lastName으로 DB에서 Employee를 찾고

- 존재하는 경우 "Hello firstName lastName !"을
- 존재하지 않는 경우 "Who is this lastName you're talking about?"을
반환한다.

예제 코드는 백명석님의 [atdd-example](https://github.com/msbaek/atdd-example)을 참고하였습니다.

---

### 소감

인수테스트 기반으로 테스트를 작성하면 자연스럽게 테스트 케이스가 기능 명세서가 될 수 있다.

테스트의 목적은 프로젝트에 도움이 되기 위한 것으로 인수테스트 기반의 테스트 코드 작성을 지향해야 마땅하다고 생각한다.

restAssured에 대해서는 원격의 CI서버에서 원격의 검증 서버에 대한 통합 테스트를 해야할 때를 위해 사용하셨는데

실제로 이러한 경험을 해보지 않아서 현재의 레벨에서는 Spring Mock Mvc로 대체해서 실습해봐도 될거같다.

---

### References

- [ATDD 기반 Web Application 개발](https://github.com/msbaek/atdd-example/blob/master/README.md)
- [atdd by example](https://www.youtube.com/watch?v=affikK1obXw)
- [Outside In TDD, ATDD를 예제를 통해서 알아봅니다.](https://www.youtube.com/watch?v=EFB-h5jMFDk)
- [우아한 ATDD 정리글](https://data-make.tistory.com/724)
- [우아한 ATTD 영상](https://www.youtube.com/watch?v=ITVpmjM4mUE&list=WL&index=3)
- [유용한 테스트 케이스를 위한 개발자의 자세](https://blog.shiren.dev/2020-06-15-%EC%9C%A0%EC%9A%A9%ED%95%9C%ED%85%8C%EC%8A%A4%ED%8A%B8%EC%BC%80%EC%9D%B4%EC%8A%A4%EB%A5%BC%EC%9C%84%ED%95%9C%EA%B0%9C%EB%B0%9C%EC%9E%90%EC%9D%98%EC%9E%90%EC%84%B8/)
