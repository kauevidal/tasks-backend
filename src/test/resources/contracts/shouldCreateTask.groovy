package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should create a task"
    request {
        method 'POST'
        url '/todo'
        headers {
            contentType(applicationJson())
        }
        body(
                description: "task 1",
                dueDate: "2025-01-01"
        )
    }
    response {
        headers {
            contentType(applicationJson())
        }
        status CREATED()
        body([
                id         : $(regex(anInteger())),
                description: "task 1",
                dueDate    : "2025-01-01"
        ])
    }
}
