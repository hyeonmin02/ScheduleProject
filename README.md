# ScheduleProject
## 📌 일정(Schedule) API 명세

| Method | 기능            | Endpoint           | 상태 코드 |
|--------|-----------------|--------------------|-----------|
| POST   | 일정 생성        | `/schedules`       | 201 CREATED |
| GET    | 선택 일정 조회   | `/schedules/{id}`  | 200 OK |
| GET    | 전체 일정 조회   | `/schedules`       | 200 OK |
| DELETE | 일정 삭제        | `/schedules/{id}`  | 204 NO CONTENT |
| PUT    | 일정 수정        | `/schedules/{id}`  | 200 OK |

## 📌 일정(Schedule) API 명세

---

## 1️⃣ 일정 생성

### ▶ Request
**POST** `/schedules`
```json
{
  "title": "일정 제목",
  "content": "일정 내용",
  "writer": "작성자명",
  "password": "비밀번호"
}
```
### ▶ Response
```json
{
  "id": 1,
  "title": "일정 제목",
  "content": "일정 내용",
  "writer": "작성자명",
  "createdAt": "2026-02-03T10:00:00",
  "modifiedAt": "2026-02-03T10:00:00"
}
```
## 2️⃣ 선택 일정 조회
### ▶ Request
**GET**
```
 /schedules/{id}
```
### ▶ Response (200 OK)
{
  "id": 1,
  "title": "일정 제목",
  "content": "일정 내용",
  "writer": "작성자명",
  "createdAt": "2026-02-03T10:00:00",
  "modifiedAt": "2026-02-03T10:00:00"
}
## 3️⃣ 전체 일정 조회
▶ Request

GET /schedules

▶ Response (200 OK)
[
  {
    "id": 1,
    "title": "첫 번째 일정",
    "content": "내용 1",
    "writer": "작성자1",
    "createdAt": "2026-02-03T10:00:00",
    "modifiedAt": "2026-02-03T10:00:00"
  },
  {
    "id": 2,
    "title": "두 번째 일정",
    "content": "내용 2",
    "writer": "작성자2",
    "createdAt": "2026-02-04T11:00:00",
    "modifiedAt": "2026-02-04T11:00:00"
  }
]

## 4️⃣ 일정 수정
▶ Request

PUT /schedules/{id}

{
  "title": "수정된 일정 제목",
  "content": "수정된 일정 내용",
  "writer": "작성자명",
  "password": "비밀번호"
}

▶ Response (200 OK)
{
  "id": 1,
  "title": "수정된 일정 제목",
  "content": "수정된 일정 내용",
  "writer": "작성자명",
  "createdAt": "2026-02-03T10:00:00",
  "modifiedAt": "2026-02-05T14:30:00"
}

## 5️⃣ 일정 삭제
▶ Request 
DELETE
```
/schedules/{id}
```
▶ Response (204 NO CONTENT)
