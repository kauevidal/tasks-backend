package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return all tasks"
    request {
        method 'GET'
        url '/todo'
        headers {
            contentType(applicationJson())
        }
    }
    response {
        headers {
            contentType(applicationJson())
        }
        status OK()
        body([
                id         : $(anyPositiveInt()),
                description: $(anyNonEmptyString()),
                dueDate    : $(anyDate())
        ])
    }
}
