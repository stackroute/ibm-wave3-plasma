import { DomainExpertModule } from './domain-expert.module';

describe('DomainExpertModule', () => {
  let domainExpertModule: DomainExpertModule;

  beforeEach(() => {
    domainExpertModule = new DomainExpertModule();
  });

  it('should create an instance', () => {
    expect(domainExpertModule).toBeTruthy();
  });
});
