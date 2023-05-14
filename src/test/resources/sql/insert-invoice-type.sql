insert into invoice_type (
  id,
  code,
  name,
  status_record,
  created_by,
  created_at,
  updated_by,
  updated_at
)
values(
  'ce4295af-8b45-4732-9962-3cd2eb8ed800',
  'IT-002',
  'Invoice Type Test Inactive 2',
  'INACTIVE',
  'Developer',
  '2023-05-14 08:04:21.223783',
  'Developer',
  '2023-05-14 08:04:22.223783'
),
(
  'ce4295af-8b45-4732-9962-3cd2eb8ed900',
  'IT-003',
  'Invoice Type Test Soft Delete 3',
  'ACTIVE',
  'Developer',
  '2023-05-14 08:04:21.223783',
  'Developer',
  '2023-05-14 08:04:22.223783'
);
