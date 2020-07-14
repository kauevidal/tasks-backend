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
                description: "task 2",
                dueDate: "2025-01-01"
        )
    }
    response {
        status CREATED()
        body([
                id         : $(regex(anInteger())),
                description: $(anyNonEmptyString()),
                dueDate    : $(anyDate())
        ])
    }
}
