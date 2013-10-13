# ndigits

clojure text game.

## 소개

Clojure로 개발한 숫자야구 게임.

* 중복되지 않은 숫자 n개를 순서포함해서 맞추는 게임이다.
* 답한 숫자중에서 자리까지 일치하는 경우에는 S(Strike), 숫자는 일치하지만 자리가 틀린 경우에는 B(ball)로 표시한다.

```
대상 숫자 : 1234
답한 숫자 : 1456
결과 : 1S 1B (1은 자리까지 일치하고, 4는 자리가 일치하지 않음)
```

## 사용법

실행하기 위해서는 [leiningen](https://github.com/technomancy/leiningen)과 git이 필요하다.
다음 명령어로 실행한다.

```bash
git clone https://github.com/ppodoru/ndigits.git
cd ndigits
lein deps # run this if you're using lein 1.x
lein run
```

## License

Copyright © 2013 ppodoru
