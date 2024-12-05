***
## 프로그램 개요
**편의점의 재고를 파악하고** 프로모션 **또는** 멤버십**을 적용하여 물건을 구매하는 프로그램이에요!**

자판기가 '보유'하고 있는 금액으로 동전 '무작위' 생성 (투입된 돈은 무시)
잔돈 돌려줄 때 보유하고 있는 최소 개수의 동전으로 잔돈 돌려줌

상품추가 가능
- 상품 가격은 100원부터 시작이며 10원단위로 나누어 떨어져야함

상품 구입
- 사용자가 투입한 금액으로 상품을 구매할 수 있다.
- 투입한 금액중 상품을 구매하고 남은 금액이 자판기의 물건중 최저가격보다 낮은 경우 잔돈 돌려줌.
- 모든 상품이 소진된 경우엥도 잔돈 돌려줌
    - 단, 자판기가 보유한 금액보다 돌려줘야 할 잔돈이 많은 경우 자판기의 보유금액 다 줌


# 📜 기능 명세서 📜

***

### 입출력
- [x] 자판기가 보유할 금액 입력받기
- [x] 자판기가 보유한 동전 보여주기
- [ ] 상품명, 가격, 수량 입력받기
- [ ] 투입금액 입력받기
- [ ] 구매할 상품명 입력받기
- [ ] 잔돈 출력하기

### 주요 기능
- [x] 투입된 금액을 기반으로 무작위 동전 생성하기
- [ ] 입력된 상품명, 가격, 수량 을 기반으로 재고 세팅하기
- [ ] 상품 구매후 재고 갱신해주기
- [ ] 투입 금액이 (잔존 금액도 포함) 현 자판기의 가장 싼 물건보다 싼지 판단
- [ ] 현 자판기의 남은 재고가 없다면 잔돈 반환
- [ ] 잘못된 입력이 들어올 경우 그 순간의 입력부터 다시 받기

# ❗️ 예외 상황 ❗

***
### 공통 예외
- [x] **공백 입력** ex) ` `

### 입력시 예외
- [x] 자판기 보유금액이 10원 단위로 안나누어 떨어지는 경우 ex) 333, money
- [ ] 상품명, 가격, 수량 입력 형식이 잘못된 경우 ex) [콜라,1500,20]:[사이다,1000,10], {콜라,3000,20}
- [x] 투입 금액이 10원 단위가 아닌 경우 ex) 1555

